# git常用操作



登录用户
```
git config --global user.name "Your name"
git config --global user.email "your@emial.com"
```
添加新文件到工作区
```git
git add ***.txt
```
交付文件并备注
```git
git commit -m "useful message about these files added" 
//-m(message) 
add / commit 分开处理的原因是可以分批次备注信息
```
将更新提交到远端
```
git push
```
状态查询
```
git status
```
查看日志文件
```
git log
```

删除版本库中文件

```
git rm test.txt  //git rm 和git add 其实是等效的，都是对暂存区的操作
git commit -m "rm test.txt"
```
从远程仓库克隆
```
git clone git@github.com:jasondong-1/gitpractice.git
```
branch 分支操作
```
git branch //查看所有分支 *后边的为当前分支
git branch branch_name //切换或创建分支
git merge branch_name //合并分支到当前分支
git branch -d dev //删除分支
```
更新中。。。

