var express = require('express');
var router = express.Router();
var dogController = require('../controllers/DogController')

/* GET users listing. */
router.get('/', dogController.findAllCrud);
router.post('/', dogController.createDogCrud);

module.exports = router;
