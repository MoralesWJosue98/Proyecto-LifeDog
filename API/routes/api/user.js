var express = require('express');
var router = express.Router();
const {createUser, loginUser, getAll} = require('../../controllers/UserController');

/* GET home page. */
router.post('/', createUser);
router.get('/', getAll);
router.post('/login', loginUser);

module.exports = router;
