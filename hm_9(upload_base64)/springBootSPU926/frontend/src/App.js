import logo from './logo.svg';

import './App.css';
import { Component } from 'react';
import { Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import Nav from './Components/Nav'
import Home from './Components/Home'
import AddAnimal from './Components/AddAnimal'
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom'

class App extends Component {

  //https://developer.okta.com/blog/2018/07/19/simple-crud-react-and-spring-boot
  //https://github.com/oktadev/okta-spring-boot-react-crud-example/blob/main/app/src/Home.js
  //https://jasonwatmore.com/post/2020/02/01/react-fetch-http-post-request-examples

//   componentDidMount() {
//     fetch('http://localhost:8080/api/animals')
//         .then(response => response.json())
//         .then(data => console.log(data));
//         //.then(data => this.setState({clients: data}));
// }
  render() {
    return (
      <Router>
    <div className="App">
      <Nav />
      <Switch>
      <Route path="/" exact component={Home} />
      <Route path="/Nav" component={Nav} />
      <Route path="/AddAnimal" component={AddAnimal} />
      </Switch>
    </div>
    </Router>
      // <div className="App">
      //   <header className="App-header">
      //     <img src={logo} className="App-logo" alt="logo" />
      //     <p>
      //       Edit <code>src/App.js</code> and save to reload.
      //     </p>
      //     <a
      //       className="App-link"
      //       href="https://reactjs.org"
      //       target="_blank"
      //       rel="noopener noreferrer"
      //     >
      //       Learn React
      //     </a>
      //   </header>
      // </div>
    );
  }
}

export default App;
