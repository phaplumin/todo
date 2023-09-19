import React from 'react';

import GlobalStyle from './global'
import ContextProviders from './contextProviders';

import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from './Pages/Login';
import Home from './Pages/Home';
import CategoriePage from './Pages/Categorie';
import ProtectedRoute from './Routes/Route';
import { QueryClientProvider } from 'react-query';
import { useQueryClient } from './Hooks/useQueryClient'


function App() {
  const queryClient = useQueryClient();
  return (
    <QueryClientProvider client={queryClient} contextSharing={true}>
      <ContextProviders>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Home/>} />
            {/* <Route path="/login" element={<ProtectedRoute priv={false}><Login/></ProtectedRoute>} />
             */}
            <Route path='/categorie/:name' element = {<CategoriePage/>}></Route>
          </Routes>
        </BrowserRouter>
        <GlobalStyle/>
      </ContextProviders>
    </QueryClientProvider>

  );
}

export default App;
