var express = require('express');
var router = express.Router();
var dogController = require('../controllers/DogController')

router.get('/', dogController.findAllCrud);
router.post('/', dogController.createDogCrud);

router.get('/delete-dog/:dog', dogController.deleteDog);

router.get('/update-dog/:dog', dogController.editDog);
router.post('/update-dog/:dog', dogController.updateDog);

module.exports = router;
