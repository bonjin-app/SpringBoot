# Slack Web Hook

### 설정
- 채널에서 [설정 및 관리] -> [앱 관리]로 이동.
- 앱 디렉토리 검색에 'incoming-webhook' 입력 후 검색
- 수신 웹후크 클릭
- Slack에 추가.



1. Application YML
  - slack.webhook-url: 발급받은 webhook-url 입력.

2. SlackService
  - sendMessage Call
  - 인자값으로 'text' String Data 입력.

3. EventListener -> ApplicationReadyEvent.class
  - 서버 준비가 완료되면 Slack Message Call

4. EventListener -> ApplicationFailedEvent.class
  - 서버 구동이 실패되면 Slack Message Call
