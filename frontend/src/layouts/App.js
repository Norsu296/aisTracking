import '../css/App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter as Router} from 'react-router-dom'
import Page from './Page';

function App(){
  return(
    <Router>
     <header>
     </header>
     <main>
        {<Page/>}
     </main>
     <footer>

     </footer>
     
   </Router>
  )
}

export default App;