import { React, Component } from 'react'

class Test extends Component {
    componentDidMount() {
        fetch("https://fakestoreapi.com/products/").then(x => console.log(x.json()));
    }

    render(){
        return (
            <div></div>
        )
    }
}

export default Test