window.startCountingAnimation = function () {
  let counters = document.querySelectorAll(".counter");
  counters.forEach((counter) => {
    let target = parseFloat(counter.innerText);
    let start = 0;
    let increment = target / 100;
    let duration = 2500;
    let stepTime = Math.abs(Math.floor(duration / (target / increment)));

    let interval = setInterval(() => {
      start += increment;
      if (start > target) {
        start = target;
        clearInterval(interval);
      }
      counter.innerText =
        start % 1 === 0 ? Math.floor(start) : start.toFixed(1);
    }, stepTime);
  });
};
