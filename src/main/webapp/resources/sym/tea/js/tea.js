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
