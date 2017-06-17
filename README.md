# Git FAQ on Stackoverflow 
> Git是一个开源的分布式版本控制系统，能够高速有效的进行项目版本管理。功能强大，但是随之而来的是学习成本较高，在使用过程会出现很多让人费解的问题，为了能够更好的解决使用Git遇到的问题，我将**Stackoverflow**上有代表性的Git问题归纳（后续会分类和翻译），形成这个份Git使用的FAQ，也是算是份快查手册。


## 目录


## 问题列表
#### 1. [撤销最近一次提交](http://stackoverflow.com/questions/927358/how-to-undo-last-commits-in-git)
```bash
$ git commit -m "Something terribly misguided"              (1)
$ git reset HEAD~                                           (2)
# << edit files as necessary >>                             (3)
$ git add .                                                 (4)
$ git commit -c ORIG_HEAD                                   (5)
```
(1) 这是你想撤销的一次提交。

(2) 这个操作保持你的工作树（磁盘文件）不变的情况下，撤销了提交，并保留了没有提交的修改内容。

(3) 如有需要，编辑文件。

(4) 添加所有变更到这次新的提交中。

(5) 提交更改，复用上次的提交信息。这次提交将打开一个编辑器，它显示上次提交的信息，你可以修改，当然也可以直接退出。另外使用`git commit --amend`可以修改上次提交。


#### 2. [删除本地和远程分支](http://stackoverflow.com/questions/2003505/how-to-delete-a-git-branch-both-locally-and-remotely)

- 删除本地分支

```bash
$ git branch -d <branch_name>
```
注意: `-d`选项是`--delete`的别名。

- 删除远程分支

从Git v1.7.0开始，可以使用以下命令删除远程分支：
```bash
$ git push origin --delete <branch_name>
```
这比以前更好记一些，在Git v1.5.0中增加的删除远程分支和标签：
```bash
$ git push origin :<branch_name>
```
所以，使用哪个命令和你使用的Git版本有关。

>如果删除了本地分支和远程分支，在其他机器上仍会出现`obsolete tracking branches`（使用`git branch -a`查看），那么使用`git fetch -all --prune`来摆脱这些。

#### 3. [修改未推送的提交](http://stackoverflow.com/questions/179123/how-to-modify-existing-unpushed-commits)
- 修改最近的提交信息

```bash
$ git commit --amend
```
上面命令将打开你的编辑器，允许你修改最近提交的提交信息。
此外，你也可以通过命令行直接设置提交信息：
```bash
$ git commit --amend -m "New commit message"
```
然而，这会让多行提交信息或者小的修正合入起来更繁琐。
确保在执行该操作之前没有暂存任何工作副本的更改，否则他们也会被提交（未暂存的更改不会被提交）。

- 使用交互式rebase

另外一个选择是使用交互式rebase。这允许您编辑要更新的任何消息，即使它不是最新的消息。
为了使用git压缩，需按以下步骤：
```bash
# X代表要修改最近的几次提交
$ git rebase -i HEAD~X
```
一旦你压缩了你的提交 - 选择`e/r`来编辑消息。
```bash
pick e7276cb feature: 支持chrome应用方式
pick 34d0971 featrue: 1. 支持chrome扩展，2。左右平分
pick 1d1810d 支持chrome全屏演示
pick 1f0aea5 完善Readme

# Rebase 6485579..1f0aea5 onto 6485579 (4 command(s))
#
# Commands:
# p, pick = use commit
# r, reword = use commit, but edit the commit message
# e, edit = use commit, but stop for amending
# s, squash = use commit, but meld into previous commit
# f, fixup = like "squash", but discard this commit's log message
# x, exec = run command (the rest of the line) using shell
# d, drop = remove commit
#
# These lines can be re-ordered; they are executed from top to bottom.
#
# If you remove a line here THAT COMMIT WILL BE LOST.
#
# However, if you remove everything, the rebase will be aborted.
#
# Note that empty commits are commented out
```
文档：
  - [git-commit(1) 手册](https://www.kernel.org/pub/software/scm/git/docs/git-commit.html)
  - [git-rebase(1) 手册](https://www.kernel.org/pub/software/scm/git/docs/git-rebase.html)
  - [git-push(1) 手册](https://www.kernel.org/pub/software/scm/git/docs/git-push.html)

#### 4. [在提交之前撤销git add](http://stackoverflow.com/questions/348170/how-to-undo-git-add-before-commit)
在提交`commit`之前，撤销`git add`操作：
- git reset

```bash
$ git reset <file>
```
这将从当前暂存区（即将被提交的列表）删除该它，而不改变任何其他内容。
你也可以使用以下命令:
```bash
$ git reset
```
没有所有更改中需要撤销暂存的文件名称，如果有很多文件需要被逐一列出时比较有用。
在旧版本的Git中，上述命令分别等同于`git reset HEAD <file>`和`git reset HEAD`，并且如果HEAD未定义（因为您的repo中还没有任何提交）或者有些模糊（因为您创建了一个名为HEAD的分支，您不应该做这样愚蠢的事），执行将会失败。这在Git v1.8.2中已经改变了，在现代版本的Git中，你可以在第一次提交之前使用`get reset`。

- git rm

可以使用`"git rm --cached <file>`来撤销缓存。
在你添加文件到暂存区之后，使用`git status`，会有以下输出：
```bash
 Changes to be committed:
   (use "git rm --cached <file>..." to unstage)
```

>具体使用那种方式，需要根据使用git版本决定

#### 5. [git pull和git fetch之间的不同](http://stackoverflow.com/questions/292357/what-is-the-difference-between-git-pull-and-git-fetch)



#### 6. [重命名一个本地git分支](http://stackoverflow.com/questions/6591213/how-do-i-rename-a-local-git-branch)


#### 7. [将git仓库还原到先前的提交](http://stackoverflow.com/questions/4114095/how-to-revert-git-repository-to-a-previous-commit)


#### 8. [从当前工作区中删除未跟踪的文件](http://stackoverflow.com/questions/61212/how-to-remove-local-untracked-files-from-the-current-git-working-tree)


#### 9. [检出远程git分支](http://stackoverflow.com/questions/1783405/how-to-check-out-a-remote-git-branch)


#### 10. [强制拉取并覆盖本地文件](http://stackoverflow.com/questions/1125968/how-do-i-force-git-pull-to-overwrite-local-files)


#### 11. [how to resolve merge conflicts in git](http://stackoverflow.com/questions/161813/how-to-resolve-merge-conflicts-in-git)
#### 12. [how to clone all remote branches in git](http://stackoverflow.com/questions/67699/how-to-clone-all-remote-branches-in-git)
#### 13. [how do i discard unstaged changes in git](http://stackoverflow.com/questions/52704/how-do-i-discard-unstaged-changes-in-git)
#### 14. [how can i add an empty directory to a git repository](http://stackoverflow.com/questions/115983/how-can-i-add-an-empty-directory-to-a-git-repository)
#### 15. [move the most recent commits to a new branch with git](http://stackoverflow.com/questions/1628563/move-the-most-recent-commits-to-a-new-branch-with-git)
#### 16. [how do i push a new local branch to a remote git repository and track it too](http://stackoverflow.com/questions/2765421/how-do-i-push-a-new-local-branch-to-a-remote-git-repository-and-track-it-too)
#### 17. [make an existing git branch track a remote branch](http://stackoverflow.com/questions/520650/make-an-existing-git-branch-track-a-remote-branch)
#### 18. [how do i remove a submodule](http://stackoverflow.com/questions/1260748/how-do-i-remove-a-submodule)
#### 19. [reset-or-revert-a-specific-file-to-a-specific-revision-using-git](http://stackoverflow.com/questions/215718/reset-or-revert-a-specific-file-to-a-specific-revision-using-git)
#### 20. [undo-a-git-merge-that-hasnt-been-pushed-yet](http://stackoverflow.com/questions/2389361/undo-a-git-merge-that-hasnt-been-pushed-yet)
#### 21. [how-do-you-create-a-remote-git-branch](http://stackoverflow.com/questions/1519006/how-do-you-create-a-remote-git-branch)
#### 22. [change-the-uri-url-for-a-remote-git-repository](http://stackoverflow.com/questions/2432764/change-the-uri-url-for-a-remote-git-repository)
#### 23. [how-to-make-git-forget-about-a-file-that-was-tracked-but-is-now-in-gitignore](http://stackoverflow.com/questions/1274057/how-to-make-git-forget-about-a-file-that-was-tracked-but-is-now-in-gitignore)
#### 24. [delete-commits-from-a-branch-in-git](http://stackoverflow.com/questions/1338728/delete-commits-from-a-branch-in-git)
#### 25. [view-the-change-history-of-a-file-using-git-versioning](http://stackoverflow.com/questions/278192/view-the-change-history-of-a-file-using-git-versioning)
#### 26. [move-existing-uncommited-work-to-a-new-branch-in-git](http://stackoverflow.com/questions/1394797/move-existing-uncommited-work-to-a-new-branch-in-git)
#### 27. [find-and-restore-a-deleted-file-in-a-git-repository](http://stackoverflow.com/questions/953481/find-and-restore-a-deleted-file-in-a-git-repository)
#### 28. [do-a-git-export-like-svn-export](http://stackoverflow.com/questions/160608/do-a-git-export-like-svn-export)
#### 29. [remove-a-file-from-a-git-repository-without-deleting-it-from-the-local-filesyste](http://stackoverflow.com/questions/1143796/remove-a-file-from-a-git-repository-without-deleting-it-from-the-local-filesyste)

## License

[![License: CC BY 4.0](https://img.shields.io/badge/License-CC%20BY%204.0-lightgrey.svg)](https://creativecommons.org/licenses/by/4.0/)
