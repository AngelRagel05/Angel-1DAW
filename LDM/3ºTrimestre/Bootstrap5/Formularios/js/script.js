// <!-- Script de validación de Bootstrap con modificaciones de Olga, no tocar salvo los ids-->

  (() => {

   'use strict'

   const forms = document.querySelectorAll('.needs-validation')

   Array.from(forms).forEach(form => {

    form.addEventListener('submit', event => {

     // Validar hobbies manualmente

     const checkboxes = form.querySelectorAll('.hobby:checked')

     if (checkboxes.length === 0) {

      event.preventDefault()

      event.stopPropagation()

      form.querySelector('.hobby').closest('fieldset') //id de los hobbies

        .classList.add('is-invalid')

     }

     if (!form.checkValidity()) {

      event.preventDefault()

      event.stopPropagation()

     }

     // Validar coincidencia de contraseñas

     const pass = form.querySelector('#pass').value // id contraseña 1

     const pass2 = form.querySelector('#pass2').value // id contraseña 2

     if (pass !== pass2) {

      event.preventDefault()

      event.stopPropagation()

      form.querySelector('#pass2')

        .classList.add('is-invalid')

     }

     form.classList.add('was-validated')

    }, false)

   })

  })()