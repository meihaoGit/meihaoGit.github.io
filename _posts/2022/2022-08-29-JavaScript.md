---
layout: post
title: "2022 - JavaScript勉強資料"
date: 2022-08-29
category: JavaScript
tags: [JavaScript TypeScript]
---

## 参考資料

- [vitejs/vite](https://github.com/vitejs/vite)

- [create-vite](https://github.com/vitejs/vite/tree/main/packages/create-vite)

## 自分用

### 勉強リスト：

- UI

  - [UI-design](https://www.figma.com/ja/)

  - [Tailwind CSS with Vue 3 and Vite](https://tailwindcss.com/docs/guides/vite)

  - [tailwindcss](https://github.com/tailwindlabs/tailwindcss)

  - [astro](https://docs.astro.build/zh-cn/getting-started/)

  - [Complete Vue.js 3 Course: Vuejs 3, Vite, TailwindCSS, Pinia](https://vvbin.cn/next/)

  - [vue-vben-admin](https://vvbin.cn/next/) - Full version Chinese site
  - [vue-vben-admin-gh-pages](https://anncwb.github.io/vue-vben-admin/) - Full version of the github site
  - [vben-admin-thin-next](https://vvbin.cn/thin/next/) - Simplified Chinese site
  - [vben-admin-thin-gh-pages](https://anncwb.github.io/vben-admin-thin-next/) - Simplified github site
  - [vue-vben-admin-.NET](https://github.com/daiyekun/DevAdmin) - DevAdmin
  - [vue-vben JEECG BOOT](hhttps://github.com/jeecgboot/jeecg-boot) - JEECG BOOT
  - [vue3.0-typescript-starter](https://github.com/sunshine824/vue3.0-typescript-starter) -vue3.0-typescript-starter

- TypeORM

  - [TypeORM](https://typeorm.io/) -TypeORM

  - [TypeORM + Typescript の実装サンプル](https://olafnosuke.hatenablog.com/entry/2022/07/27/185707) -TypeORM + Typescript の実装サンプル

TypeORM + Typescript の実装サンプル

## VSCode 拡張機能

- VS Code（Visual Studio Code）の Vue.js の拡張機能
  - Vetur
  - Vue Language Features (Volar)
  - Vue 3 Snippets
  - PostCSS Language Support

## Mybatis Plus

- [Mybatis Plus](https://www.w3cschool.cn/mybatis_plus/mybatis_plus-j9da3mgg.html) - Mybatis Plus

## Port 8080 was already in use

- 1. mac/linux の場合

```sh
lsof -i -P | grep 8080

kill -9 28795
```

- 2. Windows の場合

```sh
netstat -ano | findstr 8080

taskkill /F /pid 19508
```
