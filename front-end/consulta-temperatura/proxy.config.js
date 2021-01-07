const proxy = [
    {
      context: '/temperatura',
      target: 'http://localhost:8080',
      pathRewrite: {'^/temperatura' : ''}
    }
  ];
  module.exports = proxy;