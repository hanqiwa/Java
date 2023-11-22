package com.thealgorithms.datastructures.graphs;

import com.thealgorithms.datastructures.graphs.BoruvkaAlgorithm.Graph;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoruvkaAlgorithmTest {
    @Test
    public void testBoruvkaMSTV9E14() {
        // Test case 1
        int V1 = 9, E1 = 14;
        Graph graph1 = new Graph(V1, E1);

        graph1.addEdge(0, 1, 10);
        graph1.addEdge(0, 2, 12);
        graph1.addEdge(1, 2, 9);
        graph1.addEdge(1, 3, 8);
        graph1.addEdge(2, 4, 3);
        graph1.addEdge(2, 5, 1);
        graph1.addEdge(4, 5, 3);
        graph1.addEdge(4, 3, 7);
        graph1.addEdge(3, 6, 8);
        graph1.addEdge(3, 7, 5);
        graph1.addEdge(5, 7, 6);
        graph1.addEdge(6, 7, 9);
        graph1.addEdge(6, 8, 2);
        graph1.addEdge(7, 8, 11);

        /** Adjacency matrix
         *    0   1   2   3   4   5   6   7   8
         * 0  0  10  12   0   0   0   0   0   0
         * 1 10   0   9   8   0   0   0   0   0
         * 2 12   9   0   0   3   1   0   0   0
         * 3  0   8   0   0   7   0   8   5   0
         * 4  0   0   3   7   0   3   0   0   0
         * 5  0   0   1   0   3   0   0   6   0
         * 6  0   0   0   8   0   0   0   9   2
         * 7  0   0   0   5   0   6   9   0  11
         * 8  0   0   0   0   0   0   2  11   0
         */

        List<BoruvkaAlgorithm.Edge> result1 = BoruvkaAlgorithm.boruvkaMST(graph1);
        // Expected result:
        // Edges: 8
        // Total weight: 43
        assertEquals(8, result1.size());
        assertEquals(43, result1.stream().mapToInt(edge -> edge.weight).sum());
    }

    @Test
    void testBoruvkaMSTV2E1() {
        // Test case 2
        int V2 = 2, E2 = 1;
        Graph graph2 = new Graph(V2, E2);

        graph2.addEdge(0, 1, 10);

        /** Adjacency matrix
         *    0  1
         * 0  0  10
         * 1  10  0
         */
        List<BoruvkaAlgorithm.Edge> result2 = BoruvkaAlgorithm.boruvkaMST(graph2);
        // Expected result:
        // Edges: 1
        // Total weight: 10
        assertEquals(1, result2.size());
        assertEquals(10, result2.stream().mapToInt(edge -> edge.weight).sum());
    }

    @Test
    void testCompleteGraphK4() {
        //Test case 3
        int V3 = 4, E3 = 6;
        Graph graph3 = new Graph(V3, E3);

        graph3.addEdge(0, 1, 7);
        graph3.addEdge(0, 2, 2);
        graph3.addEdge(0, 3, 5);
        graph3.addEdge(1, 2, 3);
        graph3.addEdge(1, 3, 4);
        graph3.addEdge(2, 3, 1);

        /** Adjacency matrix
         *    0  1  2  3
         * 0  0  7  2  5
         * 1  7  0  3  4
         * 2  2  3  0  1
         * 3  5  4  1  0
         */

        List<BoruvkaAlgorithm.Edge> result3 = BoruvkaAlgorithm.boruvkaMST(graph3);
        // Expected result:
        // Edges: 3
        // Total weight: 6
        assertEquals(3, result3.size());
        assertEquals(6, result3.stream().mapToInt(edge -> edge.weight).sum());
    }


    @Test
    void testEmptyGraph() {
        // Test case 4 - Test empty graph
        int V3 = 0, E3 = 0;
        Graph graph3 = new Graph(V3, E3);

        List<BoruvkaAlgorithm.Edge> result3 = BoruvkaAlgorithm.boruvkaMST(graph3);
        assertTrue(result3.isEmpty());
    }
}
