var config = require('../config.json');


export function fetchUtil(URL, data, callback) {
  fetch(config.urlBase + URL)
      .then(function(response) {
        if (response.status >= 400) {
          throw new Error("Bad response from server");
        }
        return response.json();
      })
      .then(result => {
        callback(result)
       });
}
