# AI Fix Notes

Session: seq-1785748400960-4uefcv19c
Repository: Ncorp30/LeetCode-Java

## Summary

- Detected actionable issues: 23
- Issues with proposed PR changes: 4
- Issues requiring manual review: 19
- Automated fix mode: partial / safety-first

## Safety Policy

High-priority findings touching security, authentication, credentials, network behavior, dependency safety, privacy, request handling, or response handling are not silently edited by the agent. They are listed for manual review unless the workflow can generate a bounded, low-risk change with enough context.

## Proposed Changes Included in This PR

- [1] (critical) Java/two-sum.java: Code will not compile: Map and HashMap are used without imports. Add `import java.util.Map;` and `import java.util.HashMap;`.
- [2] (critical) Java/two-sum.java: Syntax error in return statement: `lookup.get(target -, nums[i])` is invalid. It should likely be `lookup.get(target - nums[i])`.
- [3] (high) Java/src/net/kenyang/algorithm/LinkedListCycle.java: Cycle detection compares node values instead of node identity (`slowNode.val == fastNode.val`). This can produce false positives when distinct nodes contain the same value. Use reference comparison (`slowNode == fastNode`) for Floyd's cycle detection.
- [4] (high) Java/src/net/kenyang/algorithm/LRUCache.java: LRU cache implementation appears to use integer keys to link nodes, but the preview shows fragile state management (`iLastKey`, `iFirstKey`, map lookups on sentinel values). This design is prone to null dereferences, inconsistent list state, and edge-case failures on insert/update/remove operations. A standard doubly linked list with sentinel head/tail nodes would be safer and simpler.

## Manual Review Required

- [1] (high) Java/src/net/kenyang/algorithm/UniqueBinarySearchTrees.java: Recursive solution is exponential-time due to repeated subproblems. For larger `n`, this will be very slow. Use dynamic programming or memoization to reduce complexity to O(n^2).
  - Reason: Deferred by automated fix budget (6 issues per run).
  - Next step: Rerun a focused fix pass or review this issue manually.
- [2] (high) Java/Two-Sub.java: Public class name `Two_Sub` does not match the file name `Two-Sub.java`. Java requires the filename to match the public class name exactly, which is a compilation issue in standard setups.
  - Reason: Deferred by automated fix budget (6 issues per run).
  - Next step: Rerun a focused fix pass or review this issue manually.
- [3] (high) Java/two-sum.java: Returning null on no-match is unsafe and inconsistent with typical LeetCode expectations. Return an empty array or throw an exception depending on contract.
  - Reason: Deferred by automated fix budget (6 issues per run).
  - Next step: Rerun a focused fix pass or review this issue manually.
- [4] (medium) Java/src/net/kenyang/algorithm/BestTimeToBuyAndSellStock.java: The algorithm assumes `prices` is non-null. A null input will throw a `NullPointerException`. Add a null guard before reading `prices.length`.
  - Reason: Deferred by automated fix budget (6 issues per run).
  - Next step: Rerun a focused fix pass or review this issue manually.
- [5] (medium) Java/src/net/kenyang/algorithm/LRUCache.java: Mutable fields (`iCapacity`, `iCurrentSize`, `map`, `iLastKey`, `iFirstKey`) are package-visible rather than private, increasing coupling and risk of accidental external mutation. Encapsulate all state with `private` access and prefer clear names such as `capacity`, `size`, `head`, and `tail`.
  - Reason: Deferred by automated fix budget (6 issues per run).
  - Next step: Rerun a focused fix pass or review this issue manually.
- [6] (medium) Java/src/net/kenyang/algorithm/SameTree.java: Unsupported source file skipped: file appears to contain binary, invalid encoding, or non-text content.
  - Reason: Deferred by automated fix budget (6 issues per run).
  - Next step: Rerun a focused fix pass or review this issue manually.
- [7] (medium) Java/src/net/kenyang/algorithm/SingleNumber.java: The method assumes the array is non-null. A null input will throw a `NullPointerException`. Add an input validation guard. If empty arrays are invalid, define and enforce the contract explicitly.
  - Reason: Deferred by automated fix budget (6 issues per run).
  - Next step: Rerun a focused fix pass or review this issue manually.
- [8] (medium) Java/src/net/kenyang/algorithm/SymmetricTree.java: The recursive mirror check is correct but could be made clearer by using a single helper named `isMirror(left, right)` and formatting/brace style consistently. The current code has extra whitespace and uneven formatting.
  - Reason: Deferred by automated fix budget (6 issues per run).
  - Next step: Rerun a focused fix pass or review this issue manually.
- [9] (medium) Java/src/net/kenyang/algorithm/UniqueBinarySearchTrees.java: Potential integer overflow for Catalan numbers as `n` grows. `int` may be insufficient; consider `long` or `BigInteger` depending on expected constraints.
  - Reason: Deferred by automated fix budget (6 issues per run).
  - Next step: Rerun a focused fix pass or review this issue manually.
- [10] (medium) Java/Two-Sub.java: Using `Scanner` for interactive input and printing prompts makes this unsuitable for automated judge-style execution and harder to test. Prefer pure functions or argument-based input for algorithm repositories.
  - Reason: Deferred by automated fix budget (6 issues per run).
  - Next step: Rerun a focused fix pass or review this issue manually.
- [11] (medium) Java/two-sum.java: Filename `two-sum.java` does not match the public class name `Solution` and may cause build/tooling issues in standard Java project layouts.
  - Reason: Deferred by automated fix budget (6 issues per run).
  - Next step: Rerun a focused fix pass or review this issue manually.
- [12] (low) Java/src/net/kenyang/algorithm/BestTimeToBuyAndSellStock.java: The logic is more complex than necessary for a one-pass max-profit solution. The current indexing pattern (`prices[i-1]` and `prices[i]`) is harder to read and increases off-by-one risk. Consider a simpler single-loop approach tracking min price and max profit directly.
  - Reason: Deferred by automated fix budget (6 issues per run).
  - Next step: Rerun a focused fix pass or review this issue manually.
- [13] (low) Java/src/net/kenyang/algorithm/MaximumDepthOfBinaryTree.java: Recursive depth calculation is fine for small trees, but very deep trees may risk stack overflow. An iterative BFS/DFS approach can be safer if unbounded depth is expected.
  - Reason: Deferred by automated fix budget (6 issues per run).
  - Next step: Rerun a focused fix pass or review this issue manually.
- [14] (low) Java/src/net/kenyang/algorithm/SingleNumber.java: Parameter name `A` is non-idiomatic for Java and reduces readability. Prefer `nums` or `values` for clarity.
  - Reason: Deferred by automated fix budget (6 issues per run).
  - Next step: Rerun a focused fix pass or review this issue manually.
- [15] (low) Java/src/net/kenyang/algorithm/SymmetricTree.java: Inner `TreeNode` class is non-static, which unnecessarily couples nodes to the outer `SymmetricTree` instance and can make tests and reuse harder. Prefer a `static` nested class or a shared node model.
  - Reason: Deferred by automated fix budget (6 issues per run).
  - Next step: Rerun a focused fix pass or review this issue manually.
- [16] (low) Java/src/net/kenyang/algorithm/SymmetricTree.java: Recursive depth can cause stack overflow on extremely deep trees. An iterative queue-based solution would be more robust for untrusted input sizes.
  - Reason: Deferred by automated fix budget (6 issues per run).
  - Next step: Rerun a focused fix pass or review this issue manually.
- [17] (low) Java/src/net/kenyang/algorithm/UniqueBinarySearchTrees.java: Method name `numTrees` is fine, but the implementation lacks comments explaining the recurrence relation, which would improve readability for future maintainers.
  - Reason: Deferred by automated fix budget (6 issues per run).
  - Next step: Rerun a focused fix pass or review this issue manually.
- [18] (high) Java/src/net/kenyang/algorithm/ReverseInteger.java: Integer overflow is not handled when reversing digits. Inputs near `Integer.MAX_VALUE`/`Integer.MIN_VALUE` can wrap silently and return incorrect results. Add overflow checks before multiplying/adding, and return 0 or use a wider type with bounds validation.
  - Reason: Deferred by automated fix file budget (3 files per run).
  - Next step: Rerun a focused fix pass for this file or update it manually.
- [19] (high) Java/src/net/kenyang/algorithm/SameTree.java: Potential null dereference in the condition `(p.val != q.val)` if only one node is null. Although earlier branches attempt to handle nulls, the condition is brittle. Refactor to return early when either is null and then compare values after both are known non-null.
  - Reason: Deferred by automated fix file budget (3 files per run).
  - Next step: Rerun a focused fix pass for this file or update it manually.