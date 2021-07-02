var express = require('express');
const { deleteUser } = require('../controllers/UserController');
var router = express.Router();
userController = require('../controllers/UserController');

/* GET home page. */
router.get('/', userController.getAllCrud);
router.post('/', userController.createUserCrud);
  
module.exports = router;
