json.array!(@labels) do |label|
  json.extract! label, :id, :question_id, :name, :user_id
  json.url label_url(label, format: :json)
end
