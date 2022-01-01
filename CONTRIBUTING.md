# Contributing to DFont
🎉 First off, thanks for taking the time to contribute!. Any contribution you make will be much appreciated. 🎉



## Table of contents:
- [What to work on](#what_to_work_on)
- [How to contribute](#how_to_contribute)
- [Branches structure](#branches_structure)



## <a name="what_to_work_on">What to work on</a>
In [this project](https://github.com/mahmoud-abdallah863/DFont/projects/2) you can see
all the tasks for release v0.1

What to do:

1 - Check all the tasks in `To do` column.

2 - Choose a task that you like.

3 - Add your github username at the beginning of the task.
(Check `testing` tasks as an example).

4 - Move the task to `In progress` column.

**Note**: Please if you stopped working on a task, remove your github username and move it
back to `To do` column, because other developers might be interested to work on the task
as well.

5 - When you finish the task. Create a pull request to `dev` branch and add
`@mahmoud-abdallah863` as a reviewer. Then move the task to `Under Review` column.

6 - Wait for review result. We will move the task to `done` or back to `In progress` column
depending on the review results.

Aaand that's it.


## <a name="how_to_contribute">How to contribute</a>
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

### Pull Request
Never create a PR on `main` branch. Usually you should create it on `dev` branch,
unless you need to do it on some `feature` or bug branch.

### Questions
Open a new issue with the `question` label, and we will talk about it.


## <a name="branches_structure">Branches structure<a/>
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