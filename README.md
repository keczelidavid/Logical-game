# Logical Game  

## Problem Description  
In this logical game, the objective is to move a figure from the **S** marked square to the **C** marked square on the board shown in Figure 27.  

- The figure can move **vertically** or **horizontally** by one square per step.  
- From a **white square**, the figure **must** move forward, continuing in the direction of the previous step.  
- From a **red square**, the figure can either move forward or **turn right** relative to its current direction.  
- From a **blue square**, the figure can either move forward or **turn left** relative to its current direction.  
- Before the first step, the figure's direction is set to **north**. Thus, the first step must be in that direction.  

---

## Solution  
The sequence is represented as follows:  
- The first number indicates the direction of movement:  
  - `0` - up  
  - `1` - right  
  - `2` - down  
  - `3` - left  
- Followed by the figure's `x` and `y` coordinates.  

---

## Step-by-Step Movement  

```plaintext
Figure: x: 6 y: 0 -> Starting Position  
0 Figure: x: 5 y: 0  
0 Figure: x: 4 y: 0  
1 Figure: x: 4 y: 1  
1 Figure: x: 4 y: 2  
1 Figure: x: 4 y: 3  
2 Figure: x: 5 y: 3  
2 Figure: x: 6 y: 3  
3 Figure: x: 6 y: 2  
0 Figure: x: 5 y: 2  
0 Figure: x: 4 y: 2  
0 Figure: x: 3 y: 2  
0 Figure: x: 2 y: 2  
0 Figure: x: 1 y: 2  
3 Figure: x: 1 y: 1  
3 Figure: x: 1 y: 0  
2 Figure: x: 2 y: 0  
2 Figure: x: 3 y: 0  
1 Figure: x: 3 y: 1  
1 Figure: x: 3 y: 2  
1 Figure: x: 3 y: 3  
1 Figure: x: 3 y: 4  
0 Figure: x: 2 y: 4  
0 Figure: x: 1 y: 4  
0 Figure: x: 0 y: 4  
1 Figure: x: 0 y: 5  
1 Figure: x: 0 y: 6  
