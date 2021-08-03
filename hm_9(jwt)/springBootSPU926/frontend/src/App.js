import logo from './logo.svg';

import './App.css';
import { Component } from 'react';

class App extends Component {

  componentDidMount() {
    fetch('http://localhost:8080/api/animals')
        .then(response => response.json())
        .then(data => console.log(data));
        //.then(data => this.setState({clients: data}));
}
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
        </header>
      </div>
    );
  }
}

export default App;
