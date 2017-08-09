import React from 'react';
import BaseComponent from './BaseComponent';
import * as StrategyAction from '../actions/StrategyAction';
import TextField from 'material-ui/TextField';
import Paper from 'material-ui/Paper';
import RaisedButton from 'material-ui/RaisedButton';

class App extends BaseComponent {
 constructor() {
    super();
    this._bind('handleChangeLado1','handleChangeLado2', 'handleChangeMesa', 'send');
    this.state = {lado1: '', lado2: '', mesa: '', value: '', error: false};
}

  componentDidMount() {

  }

  componentWillUnmount(){

    }

   handleChangeLado1(event) {
       this.setState({
          lado1: event.target.value
        });
    }

    handleChangeLado2(event) {
       this.setState({
          lado2: event.target.value
        });
    }

    handleChangeMesa(event) {
       this.setState({
          mesa: event.target.value
        });
    }

    send(){
      let self = this;
      let lado1 = self.state.lado1;
      let lado2 = self.state.lado2;
      let mesa = self.state.mesa;
      self.setState({error: false});
      if(lado1 !== '' && lado2 !== '' && mesa !== ''){
        var value1 = parseFloat(lado1.replace(",", "."));
        var value2 = parseFloat(lado2.replace(",", "."));
        var value3 = parseFloat(mesa.replace(",", "."));
        if(value1 < 0 || value2 < 0 || value3 < 0){
           self.setState({value : 'Nenhum valor pode ser negativo', error: true});
        }
        if(!self.state.error && (value1 * value2) < (value3 * value3)){
          self.setState({value : 'A area do salão é menor que a area da mesa', error: true});
        }

        if(!self.state.error){
            StrategyAction.getQuantidadePessoa(lado1,lado2,mesa,function(data){
              if(data !== undefined){
                self.setState({value : 'Quantidade de pessoas:' + data});
              }
            }
          );
        }
         
      }
       
    }
 

render(){
    
    let button = <RaisedButton label="OK" primary={true} onTouchTap={this.send} style={{marginTop: 32}}/> ;
   
    return <div>      
            <div>
            <Paper zDepth={1} rounded={true} circle={false} style={{width:'500px',margin:'auto', marginTop:'60px', textAlign:'center', padding: 30}}>
              <form>
                  <TextField ref="Primeiro lado do salão" floatingLabelText={'Primeiro lado do salão'} onChange={this.handleChangeLado1}/><br/>
                  <TextField ref="Segundo lado do salão" floatingLabelText={'Segundo lado do salão'} onChange={this.handleChangeLado2}/><br/>
                  <TextField ref="Lado da mesa" floatingLabelText={'Segundo lado do salão'} onChange={this.handleChangeMesa}/><br/>
                  <TextField ref="Quantidade de pessoas" value={this.state.value} disabled={true} multiLine={true}/><br/>
                  {button}
              </form>
            </Paper>
            </div>
        </div>;
  }
}

export default App;
