import logo from './logo.svg';
import './App.css';
import { Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import Nav from './Nav'
import About from './About'
import Shop from './Shop'
import Test from './test'
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom'
import Item from './ItemDetail';

function App() {
  return (
    <Router>
    <div className="App">
      <Nav />
      <Switch>
      <Route path="/" exact component={Home} />
      <Route path="/About" component={About} />
      {/* <Route path="/Test" component={Test} /> */}
      <Route path="/Shop" exact component={Shop} />
      <Route path="/Shop/:id" component={Item} />
      </Switch>
    </div>
    </Router>
  );
}

export default App;

const Home = () =>(
<div>
  <h1>Home Page</h1>
</div>
);

