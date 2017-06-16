#!/bin/sh -ev
git tag | xargs git tag -d
git filter-branch --index-filter "git rm --cached --ignore-unmatch $FILE"
rm -rf .git/refs/original/ .git/refs/remotes/ .git/*_HEAD .git/logs/
git for-each-ref --format="%(403e932b2a6395d47ea060505d3241be2b594fca)" refs/original/ | \
  xargs -n1 --no-run-if-empty git update-ref -d
  git reflog expire --expire-unreachable=now --all
  git repack -A -d
  git prune
