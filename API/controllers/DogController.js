const Dog = require('../models/Dog');

const DogController = {
    create: async (req, res) => {
        const { name, breed, female, weight, color, birth, sterilized } = req.body; 
        try {
            const newDog = new Dog({
                name : name,
                breed: breed,
                female: female,
                weight: weight,
                color: color,
                birth: birth,
                sterilized: sterilized
            });

            await newDog.save();
            return res.status(201).json({error: false, message: `El perrito ${name} ha sido creado con éxito`})

        } catch (err) {
            return res.status(400).json(err);
        }
    },
    update: async (req, res) => {
        const {_id,name, breed, female, weight, color, birth, sterilized} = req.body;
        try {
            await Dog.updateOne({_id: _id}, {name:name, breed: breed, female: female, 
                weight: weight, color: color, birth: birth, sterilized: sterilized});
            
            return res.status(200).json({error: false, message: `El perrito ${name} ha sido actualizado con éxito`});
        } catch (err) {
            return res.status(400).json(err);
        }
    },
    findAll: async(req, res) => {
        try{
            const dogs = await Dog.find({});

            return res.status(200).json({error: false, perros : dogs});
        }
        catch(err){
            return res.status(400).json(err);
        }
    },
    deleteDog: async(req, res) => {
        try{
            const {_id} = req.body;
            await Dog.deleteOne({_id : _id});

            return res.status(200).json({error: false, message: "El perrito ha sido eliminado con éxito."});
        }
        catch(err){
            return res.status(400).json(err);
        }
    }
};


module.exports = DogController