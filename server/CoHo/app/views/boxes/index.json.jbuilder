json.array!(@boxes) do |box|
  json.extract! box, :id, :kind
  json.url box_url(box, format: :json)
end
