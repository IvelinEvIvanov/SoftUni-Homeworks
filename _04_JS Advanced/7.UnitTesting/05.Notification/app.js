function notify(message) {
  let notification = document.querySelector('#notification');

  notification.addEventListener('click', function (e) {
    notification.style.display = 'none';
  });

  notification.textContent = message;
  notification.style.display = 'block';
}