# Contributing to DFont
🎉 First off, thanks for taking the time to contribute!. Any contribution you make will be much appreciated. 🎉

<br/>

## How to contribute
### Issues
If you spot a problem with the docs, first
[search if the issue exists](https://github.com/mahmoud-abdallah863/DFont/issues).
If not, you can open a new issue with the appropriate labels and explain what you found.

### Solve an issue
Scan through our [existing issues](https://github.com/mahmoud-abdallah863/DFont/issues) to find one that
interests you. You can narrow down the search using `labels` as filters.
See [labels list](https://github.com/mahmoud-abdallah863/DFont/labels) for more info.
We don't assign issues to a specific developer, but you can if you have to.

### Adding new features
Feel free to add any new feature you feel like doing. Create a branch using this 
[naming convention](#feature_branch_naming). Open a PR and add [me](https://github.com/mahmoud-abdallah863)
as a reviewer.
I'm more than happy to check it out.


### Questions
Open a new issue with the `question` label, and we will talk about it.


## Branches structure
### main
This is the main branch, Github workflows work when committing or creating PR. When we release a new
version, it  will be from this branch. It is synced with the newly released version.

### dev
All under development features and bug fixing is on this branch, will be merged to the main
branch, when we want to release a new version.


### <a name="feature_branch_naming">feature/x</a>
When creating new features, branches are named as follows: `feature/<your_branch_name>`.
Notice the underscore. Let's use underscore to separate words.

### hotfix/x
Branches to fix bugs in the newly released version (main `branch`). 
Same naming convention as for `feature/x` branches.

### bugfix/x
Branches to fix any bugs in `feature/` or `dev` branches. 