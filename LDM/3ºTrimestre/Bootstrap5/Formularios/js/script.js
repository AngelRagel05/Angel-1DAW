(() => {
  'use strict'
  const forms = document.querySelectorAll('.needs-validation')
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      const checkedHobbies = form.querySelectorAll('input[name="Hobbies"]:checked')
      if (checkedHobbies.length === 0) {
        event.preventDefault(); event.stopPropagation();
        form.querySelector('.invalid-feedback.d-block').classList.add('d-block')
      }
      if (!form.checkValidity()) { event.preventDefault(); event.stopPropagation(); }
      const pass1 = form.querySelector('#password1').value
      const pass2 = form.querySelector('#password2').value
      if (pass1 !== pass2) { event.preventDefault(); event.stopPropagation(); form.querySelector('#password2').classList.add('is-invalid') }
      form.classList.add('was-validated')
    }, false)
  })
})()

