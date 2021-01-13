'use strict'
var grd = grd || {}

grd.register_form = x => {
	$(`#mgr-data-mgt-stu`).empty()
	$(`#result-form`).text(`성적 등록 화면`)
	$(`
      <form id="grd-register-form">
        <h2>성적 등록</h2>
        <div class="info">
          <input class="fname" type="text" name="name" placeholder="Full name">
          <input type="text" name="name" placeholder="Email">
          <input type="text" name="name" placeholder="Phone number">
          <input type="text" name="name" placeholder="Website">
        </div>
        <p>Message</p>
        <div>
          <textarea rows="4"></textarea>
        </div>
      </form>
	`).appendTo(`#mgr-data-mgt-stu`)
	$(`<button/>`)
	.text(`등록`)
	.appendTo(`#grd-register-form`)
	.click(e => {
		e.preventDefault()
		$.getJSON(`${x}/grades/register`, d => {
			location.href = `${x}/grades/index`
		})
	})
	}