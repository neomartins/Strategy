import React from 'react';
import BaseComponent from './BaseComponent';
import App from './App';
import baseTheme from 'material-ui/styles/baseThemes/lightBaseTheme';
import getMuiTheme from 'material-ui/styles/getMuiTheme';

export default class Principal extends BaseComponent{

	getChildContext() {
        return { muiTheme: getMuiTheme(baseTheme) };
  }

	render(){
		return <div>			
					<div>
						<App/>
					</div>
				</div>;
	}
}

Principal.childContextTypes = {
        muiTheme: React.PropTypes.object.isRequired,
    };
