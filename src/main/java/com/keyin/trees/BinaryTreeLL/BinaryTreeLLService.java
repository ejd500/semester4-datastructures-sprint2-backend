package com.keyin.trees.BinaryTreeLL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BinaryTreeLLService {

    @Autowired
    BinaryTreeLLRepository binaryTreeLLRepository;

    @Autowired
    public BinaryTreeLLService(BinaryTreeLLRepository binaryTreeLLRepository) {
        this.binaryTreeLLRepository = binaryTreeLLRepository;
    }

    public BinaryTreeLL getBinaryTreeLLById(int id) {

        BinaryTreeLL result = binaryTreeLLRepository.findById(id);

            if (result.root != null) {
                return result;
            }

        return null;
    }

    public BinaryTreeLL createBinaryTreeLL(List<Integer> integerList) {
        if(integerList.isEmpty()){
            BinaryTreeLL binaryTreeLL = new BinaryTreeLL();
            binaryTreeLL.integerList = integerList;
            return binaryTreeLLRepository.save(binaryTreeLL);
        } else {


            BinaryTreeLL binaryTreeLL = new BinaryTreeLL();
            int sum = 0;

            // Calculate sum of all integers in the list
            for (Integer value : integerList) {
                sum += value;
            }

            // Find the number closest to the median
            int closestNumber = findClosestToMedian(integerList);

            binaryTreeLL.insertInteger(closestNumber);

            //        Collections.sort(integerList);

            for (int value : integerList) {
                if (value != closestNumber) {
                    binaryTreeLL.insertInteger(value);
                }
            }

            binaryTreeLL.integerList = integerList;

            return binaryTreeLLRepository.save(binaryTreeLL);
        }

    }

    public int findClosestToMedian(List<Integer> integerList) {
        // Calculate the sum of all elements in the list
        int sum = 0;
        for (int value : integerList) {
            sum += value;
        }

        // Calculate the median
        int size = integerList.size();
        int median = sum / size;

        // Find the number closest to the median
        int closestNumber = integerList.get(0); // Initialize with the first number in the list
        int minDifference = Math.abs(median - closestNumber);

        for (int i = 1; i < size; i++) {
            int currentNumber = integerList.get(i);
            int currentDifference = Math.abs(median - currentNumber);

            if (currentDifference < minDifference) {
                closestNumber = currentNumber;
                minDifference = currentDifference;
            } else if (currentDifference == minDifference && currentNumber < closestNumber) {
                closestNumber = currentNumber;
            }
        }

        return closestNumber;
    }


    public List<BinaryTreeLL> getAllTrees() {
        return (List<BinaryTreeLL>) binaryTreeLLRepository.findAll();
    }
}
