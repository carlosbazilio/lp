const lineChecker = (line, isFirstLine) => {
  let document = ``;

  if (line !== "" && isFirstLine) {
    document += `<h1>${line}</h1>`;
  } else if (line !== "" && !isFirstLine) {
    document += `<p>${line}</p>`;
  } else if (line === "") {
    document += "<br />";
  }

  return document;

};
