/**
 * 
 */
// 수정버튼
$('#modBtn').on('click', function() {
	document.forms.myFrm.action = "modBoardForm.do"; // 수정화면 호출
	document.forms.myFrm.submit();
})

// 삭제버튼
$('.btn-danger').on('click', function() {
	document.forms.myFrm.action = "removeBoardForm.do"; // 삭제화면 호출
	document.forms.myFrm.submit();
})


//댓글목록 출력.
console.log('bno:', bno);
let rpage = 1;
showList();
function showList() {
	// 댓글목록을 초기화
	$('div.content ul li:gt(2)').remove();
	svc.replyList({ bno: bno, page: rpage },
		result => {
			console.log(result);
			result.forEach(reply => {
				const row = makeRow(reply);
				row.appendTo('div.reply ul');
			})
			makePageInfo();
		},// 두번쨰 param.
		err => {
			console.log(err);
		} // 세번쨰 param
	)//end of replyList

}//목록 출력


//삭제버튼
function deleteRow(e) {
	console.log(e);
	const rno = $(e.target).parent().parent().data('rno');
	const replyer = $(e.target).parent().parent().data('replyer');

	console.log(replyer);
	if (writer == replyer) {
		svc.removeReply(rno,
		result => {
				if (result.retCode == 'OK') {
					alert('삭제완료');
					showList();
				
				} else if (result.retCode == 'NG') {
					alert('삭제를 완료할 수 없습니다.');
				} else {
					alert('알수없는 반환값');
				}
			},
			err => console.log(err))
		}else{
			alert('다른사람의 댓글을 삭제할 수 없습니다')		
		}
}


$('#addReply').on('click', function(e) {
	let reply = $('#reply').val();

	if (!writer) {
		alert('로그인하세요');
		return;
	}
	if (!reply) {
		alert('댓글 내용을 입력하세요');
		return;
	}
	svc.addReply({bno: bno, writer: writer, reply:reply},
	result => {
			if (result.retCode == 'OK') {
				//location.reload();
				const row = makeRow(result.retVal);
				row.appendTo('div.reply ul');
				//댓글초기화
				$('#reply').val('');
				svc.getTotalCount(bno, 
				result => {
					let totalCnt = result.totalCount;
					let realEnd = Math.ceil(totalCnt / 5);
					rpage = realEnd;
					showList();
				},
				err => console.log(err));
			}
	},
		err => console.log(err));
		
});


//row 생성.
function makeRow(reply = {}) {
	let tmp1 = $('div.reply li:nth-of-type(3)').clone();
	tmp1.css('display', 'block');
	tmp1.on('dblclick', function(e){
		$('#myModal').css('display', 'block');
		let replyNo = $(e.target).parent().children().eq(0).text();
		let reply = $(e.target).parent().children().eq(1).text();
		$('.modal-content p:eq(0)').text('댓글번호 : ' + replyNo);
		$('.modal-content p:eq(1)').find('input').val(reply);
	});
	tmp1.attr('data-rno', reply.replyNo);
	tmp1.attr('data-replyer', reply.replyer);
	tmp1.find('span:eq(0)').text(reply.replyNo);
	tmp1.find('span:eq(1)').text(reply.reply);
	tmp1.find('span:eq(2)').text(reply.replyer);
	return tmp1;
}

$('.modal-content button').on('click', function(){
	svc.modifyReply({replyNo: replyNo, reply: reply},
	result => {
		if (result.retCode == 'OK') {
			alert('수정완료.');	
			$('#myModal').css('display', 'none');
			showList();
		}
	},
	err => console.log(err));
	
})


//페이징 생성.
let pagination = $('div.pagination');

function makePageInfo(){
	svc.getTotalCount(bno,
		createPageList	//성공햇을떄 실행할 함수
		),
		err => console.log(err);
}


function createPageList(result) {
	
	//페이지 속성 지정.
	let totalCnt = result.totalCount;
	let startPage, endPage, realEnd;
	let prev, next;

	realEnd = Math.ceil(totalCnt / 5);

	endPage = Math.ceil(rpage / 5) * 5;
	startPage = endPage - 4;
	endPage = endPage > realEnd ? realEnd : endPage;

	prev = startPage > 1;
	next = endPage < realEnd;

	// a 태그 생성. 
	pagination.html('');

	//이전 페이지 여부.
	if (prev) {
		let aTag = $('<a>&laquo;</a>').attr('href','#').attr('data-page', startPage-1);
		aTag.on('click', function(e){
			e.preventDefault(); // a 태그는 페이지이동.
			rpage = e.target.dataset.page; //페이지 지정
			showList();
		})
		aTag.appendTo(pagination);
		// pagination.append(aTag);
	}
	for (let rpg = startPage; rpg <= endPage; rpg++) {
		let aTag = $('<a />').html(rpg).attr('data-page', rpg).attr('href', rpg)
		
		if (rpg == rpage) {
			//aTag.attr('class','active')
			aTag.addClass('active');
		}
		aTag.on('click', function(e) {
			e.preventDefault(); // a 태그는 페이지이동.
			rpage = e.target.dataset.page; //페이지 지정
			showList();
		})
		pagination.append(aTag);

	}
	//이후 페이지 여부.
	if (next) {
		let aTag = $('<a>&raquo;</a>').attr('href','#').attr('data-page', endPage +1);
		
		aTag.on('click', function(e) {
			e.preventDefault(); // a 태그는 페이지이동.
			rpage = e.target.dataset.page; //페이지 지정
			showList();
		})
		pagination.append(aTag);
	}
}

