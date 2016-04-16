class Answer < ActiveRecord::Base
  acts_as_votable
  belongs_to :user
  belongs_to :question
  mount_uploader :picture, PictureUploader
end
