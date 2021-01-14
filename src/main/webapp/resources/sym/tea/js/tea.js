var tea = tea || {}
tea.access = x => {
	$.ajax({
		url: `${x}/teachers/access`,
		type: `post`,
		data: JSON.stringify({email: $(`#tid`).val(), password:$(`#tpwd`).val()}),
		dataType: 'json',
		contentType: 'application/json',
		success: d => {
			location.href = `${x}/tea/index`
		},
		error: e => {
			alert(`Fail`)
		}
	})
} 

tea.grade_mgmt = x => {
	$.getJSON(`${x.ctx}/teachers/page/${x.pageSize}/${x.pageNum}/subject/${x.subNum}/${x.examDate}`, d => {
		const list = d.list
		const page = d.page
		$(`<h3/>`)
		.attr({id: `title`})
		.text(`${list[0].subject} ${list[0].examDate} 성적`)
		.appendTo(`#mgr-data-mgt-stu`)
		$(`<table/>`)
		.attr({id: `tab`})
		.css({width: `100%`})
		.appendTo(`#title`) 
		$(`<tr/>`).attr({id: `tr_1`}).appendTo(`#tab`)
		$.each([`No`,`아이디`,`이름`,`생년월일`,`성별`,`점수`, `학점`], 
		    (i, j) => {
			$(`<th>${j}</th>`).css({backgroundColor: `#bfb6b6`, fontSize: `Medium`})
			.appendTo(`#tr_1`)
		})
		$.each(list, 
			(i, j) => {
			$(`<tr><td>${j.stuNum}</td>
		   	    		<td>${j.userid}</td>
		   	    		<td>${j.stuName}</td>
						<td>${j.birthday}</td>
						<td>${j.gender}</td>
						<td>${j.score}</td>
						<td>${j.grade}</td></tr>`)
						.css({padding: `15px`, textAlign: `left`, fontSize: `small`})
						.appendTo(`#tab`)
		})
		
		$(`<div/>`)
		.attr({id: `stu_page`})
		.addClass(`pagination`)
		.appendTo(`#mgr-data-mgt-stu`)
		
		function* range(start, end){
			yield start;
			if(start === end) return;
			yield* range(start + 1, end);
		}
		if(page.existPrev){
			$(`<a/>`)
			.attr({href: `#`})
			.text(`<<`)
			.appendTo(`#stu_page`)
			.click(e=>{
				e.preventDefault()
				$(`#mgr-data-mgt-stu`).empty()
				tea.grade_mgmt({ctx: x.ctx, 
								pageSize: `10`, 
								pageNum: page.prevBlock, 
								subNum: list[0].subNum,
								examDate: list[0].examDate})
			})
		}
		$.each([...range(page.startPage, page.endPage)],
			(i, j) => {
			$(`<a/>`)
			.attr({href: `#`})
			.css({backgroundColor: (j !== page.pageNum) ? `white` : `#F0B6B6`})
			.text(`${j}`)
			.appendTo(`#stu_page`)
			.click(e=>{
				e.preventDefault()
				$(`#mgr-data-mgt-stu`).empty()
				tea.grade_mgmt({ctx: x.ctx, 
								pageSize: `10`, 
								pageNum: j,
								subNum: list[0].subNum,
								examDate: list[0].examDate})
				})
		})
		if(page.existNext){
			$(`<a/>`)
			.attr({href: `#`})
			.text(`>>`)
			.appendTo(`#stu_page`)
			.click(e=>{
				e.preventDefault()
				$(`#mgr-data-mgt-stu`).empty()
				tea.grade_mgmt({ctx: x.ctx, 
								pageSize: `10`, 
								pageNum: page.nextBlock,
								subNum: list[0].subNum,
								examDate: list[0].examDate})
			})
		}
	})
}



tea.register = x => {
	$.ajax({
          url: `${x}/teachers`,
          type: 'POST',
          data: JSON.stringify({
              email: $('#email').val(),
              password: $('#password').val()
          }),
          dataType: 'json',
          contentType: 'application/json',
          success: d => {
             location.href='/transfer/sym/tea/index'
          },
          error: e => {
              console.log(`관리자등록 실패: ${e.responseText}`)
              location.href = '/move/cmm/404'
          }
      })
}
