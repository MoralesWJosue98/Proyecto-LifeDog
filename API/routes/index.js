var express = require('express');
var router = express.Router();
userController = require('../controllers/UserController');

router.get('/', userController.getAllCrud);
router.post('/', userController.createUserCrud);

router.get('/delete/:id', userController.deleteUser);

router.get('/update/:id', userController.editUser);
router.post('/update/:id', userController.updateUser);

module.exports = router;
