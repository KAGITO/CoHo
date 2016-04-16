json.array!(@replies) do |reply|
  json.extract! reply, :id, :micropost_id, :body, :user_id
  json.url reply_url(reply, format: :json)
end
