package com.keyin.trees.BinaryTreeLL;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BinaryTreeLLController {
    @Autowired
    private BinaryTreeLLService binaryTreeLLService;
    @Autowired
    private BinaryTreeLLRepository binaryTreeLLRepository;
//    private IntegerListRepository integerListRepository;

    @PostMapping("tree")
    public BinaryTreeLL createBinaryTreeLL(@RequestBody List<Integer> integerList) throws JsonProcessingException {
        return binaryTreeLLService.createBinaryTreeLL(integerList);
    }

    @GetMapping("tree/{id}")
    public BinaryTreeLL getBinaryTreeLLById(@PathVariable int id) {
        return binaryTreeLLService.getBinaryTreeLLById(id);
    }

    @GetMapping("trees")
    public List<BinaryTreeLL> getAllTrees(){
          return binaryTreeLLService.getAllTrees();
    }


}
