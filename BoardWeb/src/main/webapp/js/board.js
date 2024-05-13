/**
 * 
 */
// 수정버튼
document.querySelector("#modBtn").addEventListener('click', function() {
	document.forms.myFrm.action = "modBoardForm.do"; // 수정화면 호출
	document.forms.myFrm.submit();
})

// 삭제버튼
document.querySelector(".btn-danger").addEventListener('click', function() {
	document.forms.myFrm.action = "removeBoardForm.do"; // 삭제화면 호출
	document.forms.myFrm.submit();
})

//댓글목록 출력.
console.log('bno:', bno);

fetch('replyList.do?bno=' + bno)
	.then(resolve => resolve.json())
	.then(result => {
		console.log(result);
		result.forEach(reply => {
			let tmp1 = document.querySelector('div.reply li:nth-of-type(3)').cloneNode(true);
			console.log(tmp1);
			tmp1.style.display = 'block';
			tmp1.setAttribute('data-rno', reply.replyNo); //실제 replyNo를 가지고잇는 reply를 담아둔다
			tmp1.querySelector('span:nth-of-type(1)').innerText = reply.replyNo;
			tmp1.querySelector('span:nth-of-type(2)').innerText = reply.reply;
			tmp1.querySelector('span:nth-of-type(3)').innerText = reply.replyer;
			document.querySelector('div.reply ul').appendChild(tmp1);
		})

	})
	.catch(err => {
		console.log(err);
	})
	
	
function deleteRow(e){
	console.log(e);
	const rno = e.target.parentElement.parentElement.dataset.rno;
	console.log(rno);
	fetch('removeReply.do?rno='+rno)
	.then(resolve => resolve.json())
	.then(result => {
		if(result.retCode == 'OK'){
			alert('삭제완료');
			e.target.parentElement.parentElement.remove();
			
		}else if (result.retCode == 'NG'){
			alert('삭제를 완료할 수 없습니다.');
		}else {
			alert('알수없는 반환값');
		}
	})
	.catch(err => console.log(err))
}

document.getElementById('addReply').addEventListener('click',function(e) {
	let reply = document.getElementById('reply').value;
	fetch('addReply.do?bno='+ bno +'&replyer='+ writer +'&reply='+ reply)
	.then(resolve => resolve.json())
	.then(result => {
		if(result.retCode == 'OK'){
			location.reload();
		}
		
	})
	.catch(err => console.log(err));
})

