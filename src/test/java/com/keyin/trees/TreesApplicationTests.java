package com.keyin.trees;

import com.keyin.trees.BinaryTreeLL.BinaryTreeLL;
import com.keyin.trees.BinaryTreeLL.BinaryTreeLLRepository;
import com.keyin.trees.BinaryTreeLL.BinaryTreeLLService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TreesApplicationTests {

	@Autowired
	BinaryTreeLLRepository repository;
	@Autowired
	BinaryTreeLLService binaryTreeLLService;

	@Test
	void contextLoads() {
	}

	@Test
	void getBinaryTreeLLByIdReturnsBinaryTree() {

		int id = 101;

		BinaryTreeLL tree = binaryTreeLLService.getBinaryTreeLLById(id);

		assertNotNull(tree);
		assertEquals(id, tree.getId());
		assertInstanceOf(BinaryTreeLL.class, tree);
	}

	@Test
	void createBinaryTreeLLReturnsBalancedBinaryTree(){
		List<Integer> integerList = new ArrayList<>();
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		BinaryTreeLL binaryTree = binaryTreeLLService.createBinaryTreeLL(integerList);

		assertNotNull(binaryTree);
		assertEquals("2", binaryTree.getRoot().value);
		assertEquals("1", binaryTree.getRoot().getLeftChild().value);
		assertEquals("3", binaryTree.getRoot().getRightChild().value);
	}

	@Test
	void getAllTreesReturnsArrayListOfTrees(){
		assertInstanceOf(ArrayList.class, binaryTreeLLService.getAllTrees());
		for (BinaryTreeLL binaryTree : binaryTreeLLService.getAllTrees()){
			assertInstanceOf(BinaryTreeLL.class, binaryTree);
		}
	}
}
