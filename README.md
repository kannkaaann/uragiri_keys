# Uragiri Skill Keys (Fabric 1.21.4 / クライアント専用)

キー設定画面の「裏切りスキル」カテゴリに8スキルのキーが追加されます(初期状態は未割り当て)。
押すと `/trigger sk_<スキル名>` を送信します。対応するデータパック(uragiri_dp_key_skills)が必要です。

## ビルド (JDK 21 が必要)
    ./gradlew build
出力: build/libs/uragiri_keys-1.0.0.jar (※ -sources ではない方)

## CurseForge
- 自分用/限定配布: CurseForgeアプリのプロファイルの mods フォルダに jar を入れる、
  またはモッドパックの overrides/mods に同梱。
- CurseForge上でモッドパックを公開する場合: このMODもCurseForgeにプロジェクトとして
  アップロード(審査あり)し、モッドパックの依存に追加する。
- 必須: Fabric Loader + Fabric API (1.21.4)。
