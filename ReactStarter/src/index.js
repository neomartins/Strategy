import React from 'react';
import ReactDOM from 'react-dom';
import Principal from './components/Principal';
import { Router,  Route, useRouterHistory} from 'react-router';
import './index.css';
import injectTapEventPlugin from 'react-tap-event-plugin';
import {createHashHistory} from 'history';

injectTapEventPlugin();

ReactDOM.render(
		 <div>
		  <Router history={useRouterHistory(createHashHistory)({queryKey: false})}>
		   <Route path="/" component={Principal} />
		  </Router>
		 </div>
 
  ,document.getElementById('root')
);
