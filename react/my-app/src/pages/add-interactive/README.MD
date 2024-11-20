## state: a component's memory (page1)

## Render and commit (page2)
1. Triggering 
2. Rendering 
3. Committing 


## state as a snapshot (page3)
```
console.log(count);  // 0
setCount(count + 1); // Request a re-render with 1
console.log(count);  // Still 0!
```


## updating objects in state
not updating in state

