[**Git 教程**](https://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000)
## 1. 安装git失败
```
root@ubuntu:/root# sudo apt-get install git
Reading package lists... Done
Building dependency tree       
Reading state information... Done
Some packages could not be installed. This may mean that you have
requested an impossible situation or if you are using the unstable
distribution that some required packages have not yet been created
or been moved out of Incoming.
The following information may help to resolve the situation:

The following packages have unmet dependencies:
 git : Depends: liberror-perl but it is not installable
E: Unable to correct problems, you have held broken packages.

```
#### apt-get
- apt-get(Advanced Package Tool)是一条linux命令，适用于deb包管理式的操作系统，主要用于自动从互联网的软件仓库中搜索、安装、升级、卸载软件或操作系统。
- apt-get命令一般需要root权限执行，所以一般跟着sudo命令。
#### 解决方案
update apt-get，试着跑一下命令：
- sudo apt-get update  
- sudo apt-get upgrade
- sudo apt-get install -f 
- ---
## 2. vi 编辑器按上下左右出现字母问题
- 由于Ubuntu预安装的是tiny版本，就会导致我们在使用上的产生不便。所以我们要安装vim的full版本。
- 首先，先卸掉旧版的vi，输入以下命令： sudo apt-get remove vim-common
- 然后安装full版的vim，输入命令：sudo apt-get install vim
- 这样安装好了之后的VI就没有那么难用了。

#### 创建shh 

```
$ ssh-keygen -t rsa -C "296231930@qq.com"
```
#### Create a new repository(MyXiangTang/Really-train)
- Repository name：Really-train
- Description :MyXiangTang's first Repository 
#### SSH keys / Add new
- title:The First ssh Key
- Key:
```
ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDJk/U63K+G7mXBmm3ln+pWCdbWm7Z5bSAe+uXGjrbz3pyHjh7lSQ9WQCYUBPt7yii5udW6vLrB2ZlKwgtGmDzYkEbeprh5mKth1oDTzz+lgMmMeNrmkeAlQos5qYBW0fVCLLp3IFMnQsm7eLPzdJk2OOFB45B3/F3lscLWLRqxwmayM2XibQm6iPSN+mo2mN9EvxR5J/7ur0CdrRw1P9D12eF5mwRIvygEABAzF/w19qgpokg0hfg7hg/lk2aInNzL5VJ6jHzTtpVQcTGmoCXt9PeNUVhnH+sdykPIOmQyy8VTArnw10O3GH2SrowaeCfkpthmnFGC/9xwamH+00Ct 296231930@qq.com

```
- GitHub仓库 关联本地仓库

```
$ git remote add origin git@github.com:MyXiangTang/Really-train.git
```
- 把本地库的内容推送到远程，用git push命令，实际上是把当前分支master推送到远程。
```
$ git push -u origin master
```
- 由于远程库是空的，我们第一次推送master分支时，加上了-u参数，Git不但会把本地的master分支内容推送的远程新的master分支，还会把本地的master分支和远程的master分支关联起来，在以后的推送或者拉取时就可以简化命令。
- 从现在起，只要本地作了提交，就可以通过命令：
```
$ git push origin master
```
- 把本地master分支的最新修改推送至GitHub，现在，你就拥有了真正的分布式版本库！
## 4.第一次发送远程库失败

```
tomtang@ubuntu:~/learngits$ git push -u origin master
To git@github.com:MyXiangTang/Really-train.git
 ! [rejected]        master -> master (fetch first)
error: failed to push some refs to 'git@github.com:MyXiangTang/Really-train.git'
hint: Updates were rejected because the remote contains work that you do
hint: not have locally. This is usually caused by another repository pushing
hint: to the same ref. You may want to first integrate the remote changes
hint: (e.g., 'git pull ...') before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.

```
#### 解决方案：强制push git push -f origin master
## 5. git 命令
```
-- 安装：    
$ sudo apt-get install git
-- 配置：  
$ git config --global user.name "tomtang"
$ git config --global user.email "296231930@qq.com"
-- 初始化：
$ git init
-- 基本操作
$ git add readme.txt
$ git commit -m "comment"
$ git status
$ git log 
$ git reflog
$ git diff readme.txt
$ git reset --hard HEAD^    --版本回退
$ git reset --hard 3628164   
$ git checkout -- readme.txt  --丢弃工作区的修改
$ git reset HEAD readme.txt --把暂存区的修改撤销掉（unstage），重新放回工作区
-- GitHub仓库 关联本地仓库
$ git remote add origin git@github.com:MyXiangTang/Really-train.git
--发送到远程库
$ git push origin master
```
- 分支管理
```
$ git checkout -b dev   --创建dev分支，然后切换到dev分支
$ git branch dev
$ git checkout dev  --创建dev分支，然后切换到dev分支

$ git branch    --列出所有分支，当前分支前面会标一个*号
$ git merge dev     --合并分支
$ git branch -d dev --删除分支
$ git log --graph   --查看分支合并图
```
- 多人协作
```
因此，多人协作的工作模式通常是这样：
首先，可以试图用git push origin branch-name推送自己的修改；
如果推送失败，则因为远程分支比你的本地更新，需要先用git pull试图合并；
如果合并有冲突，则解决冲突，并在本地提交；
没有冲突或者解决掉冲突后，再用git push origin branch-name推送就能成功！
如果git pull提示“no tracking information”，则说明本地分支和远程分支的链接关系没有创建，用命令git branch --set-upstream branch-name origin/branch-name。
这就是多人协作的工作模式，一旦熟悉了，就非常简单。
小结
查看远程库信息，使用git remote -v；
本地新建的分支如果不推送到远程，对其他人就是不可见的；
从本地推送分支，使用git push origin branch-name，如果推送失败，先用git pull抓取远程的新提交；
在本地创建和远程分支对应的分支，使用git checkout -b branch-name origin/branch-name，本地和远程分支的名称最好一致；
建立本地分支和远程分支的关联，使用git branch --set-upstream branch-name origin/branch-name；
从远程抓取分支，使用git pull，如果有冲突，要先处理冲突。
```
- 标签管理
```
1. 命令git tag <name>用于新建一个标签，默认为HEAD，也可以指定一个commit id；
2. git tag -a <tagname> -m "blablabla..."可以指定标签信息；
3. git tag -s <tagname> -m "blablabla..."可以用PGP签名标签；
4. 命令git tag可以查看所有标签。
5. 命令git push origin <tagname>可以推送一个本地标签；
6. 命令git push origin --tags可以推送全部未推送过的本地标签；
7. 命令git tag -d <tagname>可以删除一个本地标签；
8. 命令git push origin :refs/tags/<tagname>可以删除一个远程标签。
```

