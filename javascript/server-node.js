const http = require('http');

const hostname = '127.0.0.1';
const port = 3000;

// const server = http.createServer((req, res) => {
//   res.statusCode = 200;
//   res.setHeader('Content-Type', 'text/html');
//   res.end('<html><head><head/><body>Hello World</body></html>');
//});

const server = http.createServer(respostaServidor);

function respostaServidor(req, res) {
  console.log(req.url);
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/html');
  res.end('<html><head><head/><body>Hello World 2</body></html>');
}

server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});
