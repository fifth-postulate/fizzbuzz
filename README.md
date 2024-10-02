# Workshop Title
This template allows you to quickly flesh out a workshop.

## Usage
There are several ways to proceed. Most importantly is to get all the files in a directory and put them under version control.
Here we describe one way.

1. Crate a directory
2. Enter the directory
3. Use `git init` to put the directory under version control.
4. Add this repository as a remote with `git remote add template git@github.com:fifth-postulate/workshop-template.git`
5. Fetch the remote code `git fetch template`
6. Git checkout the main branch `git checkout -b main template/main`
7. Alter all names to signify the current workshop
8. Rebase to have a tailered commit for your workshop `git rebase -i 76de`
9. Push your fresh workshop to a remote repository of your choicing

## Development
We use Make to automate various tasks in this project. Run 

```plain
make
```

To kick things off.
