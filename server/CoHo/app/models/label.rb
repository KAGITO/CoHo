class Label < ActiveRecord::Base
  belongs_to :user
  belongs_to :question
  validates :name, presence: true
end
