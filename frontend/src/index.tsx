import React from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.css';
import 'assets/css/styles.css';
import App from './App';


ReactDOM.render(
  <React.StrictMode>
    <App />     {/* from App.tsx */}
  </React.StrictMode>,
  document.getElementById('root') //captured from index.html
);


