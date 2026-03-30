# 🚀 26-1 백엔드 배포 세미나 데모  

2026년 1학기 백엔드 배포 세미나를 위한 데모 프로젝트입니다.  

세미나 자료는 [여기](https://www.canva.com/design/DAHFDZJ7Qk0/phZDd37a8nAdFL1B8IKCBg/edit)에서 확인하실 수 있습니다.

---  

## 1. 레포지토리 포크하기  

<kbd><img width="1241" height="178" alt="image" src="https://github.com/user-attachments/assets/5fb201dc-73c0-4937-a62f-6c79e0c5a644" /></kbd>  

깃허브에 로그인한 후,  
[이 레포지토리](https://github.com/pknu-wap/backend-deploy-demo)의 우측 상단에서 **Fork** 버튼을 누릅니다.  

<br />  

<kbd><img width="739" height="576" alt="image" src="https://github.com/user-attachments/assets/1cb64fab-e229-4c3f-a1c9-2c67ef949eee" /></kbd>  

**Create fork** 버튼을 눌러 포크합니다.  
포크는 원본 레포지토리를 내 레포지토리로 복사하는 것입니다.  
(예: 원본 *github.com/**pknu-wap**/backend-deploy-demo* -> 내 레포지토리 *github.com/**psvm203**/backend-deploy-demo*)  

<br />  

## 2. 깃허브 코드스페이스 생성  

[https://github.com/codespaces](https://github.com/codespaces) 에 들어갑니다.  

<br />  

<kbd><img width="1584" height="712" alt="image" src="https://github.com/user-attachments/assets/bd2a9d63-45d9-45bf-b54a-8b97a6bb1444" /></kbd>  

우측 상단의 **New codespaces** 버튼을 누릅니다.  

<br />  

<kbd><img width="811" height="513" alt="image" src="https://github.com/user-attachments/assets/11ac6ae6-0ec5-40f4-b245-ae50f37cf6fb" /></kbd>  

**Select a repository** 로 **방금 포크한 본인의 레포지토리**를 선택합니다.  
**Create codespace** 버튼을 눌러 코드스페이스를 생성합니다.  

<br />  

<kbd><img width="1622" height="946" alt="image" src="https://github.com/user-attachments/assets/f3ad960c-1b4d-451d-b964-ca0928892c04" /></kbd>  

잠시 기다리면 코드스페이스 창이 뜹니다.  
터미널의 패널 최대화 버튼을 눌러줍니다.  

<br />  

<kbd><img width="894" height="64" alt="image" src="https://github.com/user-attachments/assets/158ba050-86b1-4dcd-b4c8-5adbe3996dbf" /></kbd>  

```console
uname -a
```

테스트를 위해 코드를 입력해봅시다.  
코드 옆의 복사 버튼을 누르면 쉽게 복사할 수 있습니다.  
결과가 사진과 비슷하게 나왔다면 성공입니다.  
`uname -a`는 현재 사용하고 있는 시스템 정보를 출력합니다.  
이를 통해 깃허브 코드스페이스는 리눅스 우분투 환경이라는 사실을 알 수 있습니다.  

<br />  

## 3. MySQL 실행  

<kbd><img width="445" height="60" alt="image" src="https://github.com/user-attachments/assets/57ba3d3f-8d54-43b3-9a46-2939f14197b6" /></kbd>  

```console
mysql -V
```
플랫폼에 따라 MySQL이 설치되어있을 수도 있고 아닐 수도 있습니다.  
`mysql -V`는 설치된 MySQL의 버전을 출력하는 명령어입니다.  
MySQL이 존재하지 않으므로 설치해봅시다.  

<br />  

<kbd><img width="1247" height="587" alt="image" src="https://github.com/user-attachments/assets/cd672250-f4f2-441b-9216-db38a6e75c8f" /></kbd>  

```console
sudo apt update
```

`apt update`는 설치 가능한 목록을 업데이트하는 작업입니다.  

<br />  

<kbd><img width="1236" height="349" alt="image" src="https://github.com/user-attachments/assets/0c8c6d52-0b22-40f8-a66f-736329abeaf3" /></kbd>  

```console
sudo apt install mysql-server
```

이제 본격적으로 MySQL을 설치해봅시다.  
`Do you want to continue? [Y/n]` 가 나오면 <kbd>y</kbd>를 입력해서 진행해줍니다.  

<br />

<kbd><img width="482" height="56" alt="image" src="https://github.com/user-attachments/assets/5e2e5ace-23a7-4558-b446-295064f81ecc" /></kbd>  

```console
mysql -V
```

다시 한 번 `mysql -V` 명령을 실행해서 설치가 정상적으로 진행되었는지 확인합니다.  

<br />

<kbd><img width="576" height="108" alt="image" src="https://github.com/user-attachments/assets/9077600a-c2b8-4aa5-8bff-4b37fd37ad4d" /></kdb>  

```console
sudo service mysql start
```

MySQL을 실행해줍니다.

<br />

```yaml
spring:
  application:
    name: community
  datasource:
    url: jdbc:mysql://localhost:3306/community
    username: root
    password: wap-backend-deploy
  jpa:
    hibernate:
      ddl-auto: update
```

Spring의 [설정 정보](https://github.com/pknu-wap/backend-deploy-demo/blob/main/src/main/resources/application.yaml)입니다.  
여기서 눈여겨봐야할 것은 포트가 `3306`, 데이터베이스 이름이 `community`, 사용자명이 `root`, 암호가 `wap-backend-deploy`라는 것입니다.  
이미 기본 포트는 `3306`, 기본 사용자명은 `root`이므로  
`community` 데이터베이스를 만들고 `root` 사용자의 암호를 `wap-backend-deploy`로 변경해주면 됩니다.  

<br />  

<kbd><img width="715" height="381" alt="image" src="https://github.com/user-attachments/assets/4d23ce37-cc8c-40de-99d2-0f3a3e1480b6" /></kdb>  

```console
sudo mysql
```

MySQL에 접속합니다.  

```sql
CREATE DATABASE community;
```

`community` 데이터베이스를 만들어줍시다.  
SQL문은 명령의 끝에 세미콜론이 포함됩니다.  
세미콜론을 빠뜨리지 않게 조심하세요.  

```sql
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'wap-backend-deploy';
```

`root` 사용자의 비밀번호를 `wap-backend-deploy`로 바꾸어줍니다.  
명령이 완료되면 <kbd>Ctrl</kbd> + <kbd>Z</kbd>를 눌러 빠져나옵니다.  

<br />  

## 4. Spring Boot 실행  

<kbd><img width="553" height="95" alt="image" src="https://github.com/user-attachments/assets/fdd976ea-02a8-4dc3-8c5e-a3d78f0949a2" /></kbd>  

```console
java --version
```

MySQL과 마찬가지로 Java도 설치되어있을 수도 있고 아닐 수도 있습니다.  
지금은 11 버전이 설치되어있는데, 21 버전을 설치해야 합니다.  

<br />  

<kbd><img width="553" height="329" alt="image" src="https://github.com/user-attachments/assets/7f3a7aae-9d73-480a-aa39-ecff37f81a9d" /></kbd>  

```console
sdk install java 21-tem
```

자바 21 버전을 설치해줍시다.  
`Do you want java 21-tem to be set as default? (Y/n):`가 나오면 <kbd>y</kbd>를 입력해줍니다.  

<br />  

<kbd><img width="560" height="89" alt="image" src="https://github.com/user-attachments/assets/96fc06fd-f87c-4557-9e47-216fd4721f82" /></kbd>  

```console
java --version
```

다시 `java --version`을 실행해보면 21 버전이 설치된 것을 확인할 수 있습니다.  

<br />  

<kbd><img width="1070" height="212" alt="image" src="https://github.com/user-attachments/assets/2b18b5a5-afbb-42cd-a4f0-a635efaeec24" /></kbd>  


```console
chmod +x gradlew
./gradlew build
```

`chmod +x gradlew`로 gradlew를 실행할 수 있게 권한을 부여합니다.  
`./gradlew build`로 프로젝트를 빌드합니다.  
빌드는 꽤 많은 시간이 걸릴 수 있습니다.  

<br />  

<kbd><img width="1562" height="857" alt="image" src="https://github.com/user-attachments/assets/5d5aa9e3-d104-4075-8273-71e02ea44cf5" /></kbd>  

```console
java -jar build/libs/community-0.0.1-SNAPSHOT.jar
```

빌드된 프로젝트 파일을 실행합니다.  
오른쪽 하단에 팝업창이 뜨면 `브라우저에서 열기`를 눌러줍니다.  

<br />  

<kbd><img width="1309" height="333" alt="image" src="https://github.com/user-attachments/assets/b1adb6f4-059c-41d1-a4bf-b71538bc0484" /></kbd>  

포트 - 첫 줄 우클릭 - 포트 가시성 - Public 을 클릭해주면 이 웹사이트에 다른 사람이 접속할 수 있게 됩니다.  
드디어 배포 설정이 끝났습니다!  

## 5. 다른 사람과 공유  

[https://github.com/pknu-wap/backend-deploy-demo/issues/1](https://github.com/pknu-wap/backend-deploy-demo/issues/1) 에 배포한 웹 사이트의 링크를 댓글로 남겨주세요!  

다른 사람들의 웹 사이트가 잘 접속되는지/잘 작동하는지 확인하고, 자신의 웹 사이트가 잘 작동하는지 옆 사람한테 확인을 부탁해보세요!  

---

세미나 내용 중 궁금하신 점이 있으시다면 언제든지 카카오톡/디스코드 **이문빈**으로 연락주세요!
