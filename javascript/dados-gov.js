  var data = {
    resource_id: '9175f184-59a0-47a4-81f8-0d3c983b3a2d', // the resource id
    limit: 5, // get 5 results
    q: 'jones' // query for 'jones'
  };
  $.ajax({
    url: 'http://dados.gov.br/api/action/datastore_search',
    data: data,
    dataType: 'jsonp',
    success: function(data) {
      alert('Total results found: ' + data.result.total)
    }
  });