import { Router, Switch, Route } from 'react-router-dom';
import Movie from 'pages/Movie';
import MoviesList from 'pages/MoviesList';
import Navbar from 'components/Navbar';
import Auth from 'pages/Admin/Auth';
import history from 'util/history';
import PrivateRoute from 'components/PrivateRoute';
import PageNotFound from 'pages/PageNotFound';

const Routes = () => (
  <Router history={history}>
    <Navbar />
    <Switch>
      <Route path="/" exact>
        <Auth />
      </Route>
      <PrivateRoute path="/movies">
      <Route path="/movies" exact>
        <MoviesList />
      </Route>
      <Route path="/movies/:movieId" exact>
        <Movie />
      </Route>
      </PrivateRoute>
      <Route path="*" component={PageNotFound} />
    </Switch>
  </Router>
);

export default Routes;
